package com.liskovsoft.smartyoutubetv2.tv.ui.widgets.focus;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.liskovsoft.smartyoutubetv2.tv.R;

/**
 * Cupertino player button: the focused control turns into a solid white disc
 * (see lb_control_button_color) and its glyph and label switch to black, like tvOS.<br/>
 * Uses onFocusChanged instead of an OnFocusChangeListener because the tooltip
 * handler already owns that listener.
 */
public class ControlButtonView extends ImageView {
    public ControlButtonView(Context context) {
        super(context);
    }

    public ControlButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ControlButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

        ViewParent parent = getParent();
        if (!(parent instanceof View)) {
            return;
        }

        View icon = ((View) parent).findViewById(R.id.icon);
        if (icon instanceof ImageView) {
            if (gainFocus) {
                ((ImageView) icon).setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
            } else {
                ((ImageView) icon).clearColorFilter();
            }
        }

        View label = ((View) parent).findViewById(R.id.label);
        if (label instanceof TextView) {
            ((TextView) label).setTextColor(gainFocus ? Color.BLACK :
                    ContextCompat.getColor(getContext(), R.color.lb_control_button_text));
        }
    }
}
