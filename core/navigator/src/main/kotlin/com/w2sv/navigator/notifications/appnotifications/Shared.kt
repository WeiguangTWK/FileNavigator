package com.w2sv.navigator.notifications.appnotifications

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.w2sv.domain.model.filetype.FileAndSourceType

internal fun FileAndSourceType.iconBitmap(context: Context, colored: Boolean = false): Bitmap? =
    context.drawableBitmap(
        drawable = iconRes,
        tint = if (colored) fileType.colorInt else null
    )

internal fun Context.drawableBitmap(@DrawableRes drawable: Int, @ColorInt tint: Int? = null): Bitmap? =
    AppCompatResources.getDrawable(this, drawable)
        ?.apply { tint?.let { setTint(it) } }
        ?.toBitmap()
