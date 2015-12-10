package Android.Zone.Utils;

import java.util.List;

import Android.Zone.Utils.rexUtils.RexUtils;
import Android.Zone.Utils.rexUtils.RexWorkHelp.Rex_Phone.PhoneEntity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class SpannableUtils {
	public interface onClickSpannableListener{
		public abstract void onClick(View widget, String phone);
	}
	/**
	 * �������ǵ绰��ͻ������,Ȼ�����ӵ���¼�
	 * @param tv
	 * @param context
	 * @param contentStr
	 * @param listener
	 */
	public static void contentToPhone(TextView tv,Context context,String contentStr,int color,final onClickSpannableListener listener){
		List<PhoneEntity> phones = RexUtils.byContextGetPhone(contentStr);
		SpannableString ss = new SpannableString(contentStr);
		for (PhoneEntity phoneEntity : phones) {
			
			final String phone = phoneEntity.str;
			ss.setSpan(new ClickableSpan(){
		         //��onClick�����п��Ա�д��������ʱҪִ�еĶ���
		         @Override
		         public void onClick(View widget){
		        	 listener.onClick(widget,phone);
		          }
		      },phoneEntity.start, phoneEntity.end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
			ss.setSpan(new UnderlineSpan(), phoneEntity.start, phoneEntity.end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
			//��Ϊ��ClickableSpan��������ɫ�ġ��������ں��������ɫ
			ss.setSpan(new ForegroundColorSpan(color), phoneEntity.start, 
					phoneEntity.end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
		}
		
		tv.setText(ss);
		//�ڵ�������ʱ������Ҫִ�еĶ���������������MovementMethod����
		tv.setMovementMethod(LinkMovementMethod.getInstance());
	}
}