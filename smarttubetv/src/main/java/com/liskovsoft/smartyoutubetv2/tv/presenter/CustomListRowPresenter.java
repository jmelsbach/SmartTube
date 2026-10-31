package com.liskovsoft.smartyoutubetv2.tv.presenter;

import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.RowHeaderPresenter;
import com.liskovsoft.smartyoutubetv2.tv.util.ViewUtil;

public class CustomListRowPresenter extends ListRowPresenter {
    public CustomListRowPresenter() {
        super(ViewUtil.FOCUS_ZOOM_FACTOR, ViewUtil.FOCUS_DIMMER_ENABLED);
        setSelectEffectEnabled(ViewUtil.ROW_SELECT_EFFECT_ENABLED);
        // Cupertino: no drop shadow. On a near-black background it reads as a dark halo around the card.
        setShadowEnabled(false);
        // Cupertino: shelf titles stay solid white instead of Leanback's 50% dimming
        setHeaderPresenter(new RowHeaderPresenter() {
            @Override
            protected void onSelectLevelChanged(RowHeaderPresenter.ViewHolder holder) {
                holder.view.setAlpha(1f);
            }
        });
    }
}
