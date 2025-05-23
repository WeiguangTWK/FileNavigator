package com.w2sv.navigator.system_broadcastreceiver.di

import com.w2sv.navigator.system_broadcastreceiver.manager.NavigatorConfigControlledSystemBroadcastReceiverManager
import com.w2sv.navigator.system_broadcastreceiver.manager.NavigatorConfigControlledSystemBroadcastReceiverManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface SystemBroadcastReceiverBinderModule {

    @Binds
    fun navigatorConfigControlledSystemBroadcastReceiverManager(
        impl: NavigatorConfigControlledSystemBroadcastReceiverManagerImpl
    ): NavigatorConfigControlledSystemBroadcastReceiverManager
}
