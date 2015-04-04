package com.lxh.farmer.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lxh.farmer.R;
import com.lxh.farmer.model.DataHelper;

/**
 * 	��½����
 */
public class LoginActivity extends Activity {
	private EditText username;
	private EditText password;
	private Button commitBtn;
	private String url = "http://farms.thinkv.cn/Token";
	private String token = null;
	//��������
	private SharedPreferences rememberPref;
	private SharedPreferences.Editor editor;
	private CheckBox rememberPW;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initView();
	}

	private void initView() {
		username = (EditText) findViewById(R.id.userName_et);
		password = (EditText) findViewById(R.id.password_et);
		commitBtn = (Button) findViewById(R.id.login_bn);
		
		rememberPref = PreferenceManager.getDefaultSharedPreferences(this);
		rememberPW = (CheckBox) findViewById(R.id.remember_pw);
		boolean isRemember = rememberPref.getBoolean("remember_password", false);
		if (isRemember) {
			//���˺ź����붼���õ��ı�����
			String usernameStr = rememberPref.getString("usernameStr", "");
			String passwordStr = rememberPref.getString("passwordStr", "");
			username.setText(usernameStr);
			password.setText(passwordStr);
			rememberPW.setChecked(true);
		}
		
		commitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//RequestQueue��һ��������ж��������Ի������е�HTTP����Ȼ����һ�����㷨�����ط�����Щ����
				RequestQueue queue = DataHelper.getDate(LoginActivity.this);
				
				//����������Ӧ�ɹ��ˣ��ص��ö���
				Listener<String> success = new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						JSONObject json = null;

						try {
							json = new JSONObject(arg0);
							//�����û���¼ͨ���˷�������֤
							token = json.getString("access_token");

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (token != null) {
							Log.e("Login", "��½�ɹ�");
							//�ж��Ƿ񱣴�����
							editor = rememberPref.edit();
							if (rememberPW.isChecked()) {
								editor.putBoolean("remember_password", true);
								editor.putString("usernameStr", username.getEditableText().toString().trim());
								editor.putString("passwordStr", password.getEditableText().toString().trim());
							} else {
								editor.clear();
							}
							editor.commit();
							
							//��½�ɹ�����ת��MenuActivity������
							Intent intent = new Intent(LoginActivity.this,
									MenuActivity.class);
							Bundle bundle = new Bundle();
							bundle.putString("access_token", token);
							intent.putExtras(bundle);
							startActivity(intent);
						}
					}
				};
				
				//����������Ӧʧ��ʱ���ص��ö���
				ErrorListener errorListener = new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
					}
				};
				
				//����Http���󣬷�ʽ��Post
				StringRequest request = new StringRequest(Method.POST, url,
						success, errorListener) {

					@Override
					//�����û���������
					protected Map<String, String> getParams()
							throws AuthFailureError {
						Map<String, String> map = new HashMap<String, String>();
						map.put("username", username.getEditableText()
								.toString().trim());
						map.put("password", username.getEditableText()
								.toString().trim());
						map.put("grant_type", "password");
						return map;
					}
				};
				
				queue.add(request);
			}
		});

	}
}