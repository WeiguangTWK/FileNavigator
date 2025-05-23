package com.w2sv.filenavigator.ui.state

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.w2sv.androidutils.os.postNotificationsPermissionRequired
import com.w2sv.composed.OnChange

@Stable
@JvmInline
value class PostNotificationsPermissionState(val state: PermissionState?)

@Composable
fun rememberPostNotificationsPermissionState(
    onPermissionResult: (Boolean) -> Unit,
    onStatusChanged: (Boolean) -> Unit
): PostNotificationsPermissionState =
    PostNotificationsPermissionState(
        state = if (postNotificationsPermissionRequired) {
            rememberPermissionState(
                permission = Manifest.permission.POST_NOTIFICATIONS,
                onPermissionResult = onPermissionResult
            )
                .also {
                    OnChange(value = it.status) { status ->
                        onStatusChanged(status.isGranted)
                    }
                }
        } else {
            null
        }
    )
