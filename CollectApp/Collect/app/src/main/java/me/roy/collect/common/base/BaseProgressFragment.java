package me.roy.collect.common.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.devspark.progressfragment.ProgressFragment;


public class BaseProgressFragment extends ProgressFragment {

	
	protected boolean isActive;
	protected boolean isDataChanged;
	private OnSyncDataListener onSyncDataListener;
	
	private Intent intentReceived;

	protected BroadcastReceiver syncDataReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (onSyncDataListener != null) {
				if(isActive){
					onSyncDataListener.onReceive(context, intent);
				}else{
					intentReceived = intent;
					isDataChanged = true;
				}
			}
		}

	};

	@Override
	public void onResume() {
		isActive = true;
		if(isDataChanged && onSyncDataListener != null){
			onSyncDataListener.onReceive(getActivity(), intentReceived);
			isDataChanged = false;
		}
		super.onResume();
	}

	@Override
	public void onPause() {
		isActive = false;
		super.onPause();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(BaseConstants.CHANGE_DATA＿ACTION);
		getActivity().registerReceiver(syncDataReceiver, intentFilter);
	}
	
	

	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(syncDataReceiver);
		super.onDetach();
	}

	protected void setOnSyncDataListener(OnSyncDataListener i) {
		this.onSyncDataListener = i;
	}

	protected interface OnSyncDataListener {
		public void onReceive(Context context, Intent intent);
	}
}
