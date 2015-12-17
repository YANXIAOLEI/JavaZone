package Android.Zone.Abstract_Class.Adapter;

import java.util.List;

import Android.Zone.Abstract_Class.Adapter.core.BaseAdapter_Zone;
import android.content.Context;

/**
 * @author Zone
 */
public abstract class Adapter_Zone<T> extends BaseAdapter_Zone<T> {
	/**
	 * @param context
	 * @param data
	 * @param layout_id
	 */
	public Adapter_Zone(Context context, List<T> data) {
		super(context,data);
	}
	@Override
	public int getLayoutID(int position) {
		return setLayoutID();
	}
	public abstract  int setLayoutID();
}