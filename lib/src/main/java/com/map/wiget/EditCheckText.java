package com.map.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by MacBookPro on 11/28/16.
 */

public class EditCheckText extends EditText {
    public static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    public static final String EMAIL_REGEX = "/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/";
    private int icDone;
    private int icError;
    
    public EditCheckText(Context context) {
        super(context);
    }

    public EditCheckText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditCheckText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EditCheckText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context,AttributeSet attrs, int defStyleAttr){
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditCheckText, defStyleAttr, 0);
        icDone = a.getResourceId(R.styleable.EditCheckText_editIconDone,0);
        icError = a.getResourceId(R.styleable.EditCheckText_editIconError,0);
        if (icDone!=0&&icError!=0){
            checkText();
        }
    }

    private void checkText() {
        if ((this.getInputType() & InputType.TYPE_TEXT_VARIATION_PERSON_NAME) != 0) {
            checkTye(NAME_REGEX);
        } else if ((this.getInputType() & InputType.TYPE_DATETIME_VARIATION_DATE) != 0) {
            checkTye(DATE_REGEX);
        } else if ((this.getInputType() & InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS) != 0) {
            checkTye(EMAIL_REGEX);
        }
    }

    private void checkTye(String regex) {
        if (this.getText().toString().matches(regex)){
            this.setCompoundDrawablesWithIntrinsicBounds(0,0,icDone,0);
        }else {
            this.setCompoundDrawablesWithIntrinsicBounds(0,0,icError,0);
        }
    }

}
