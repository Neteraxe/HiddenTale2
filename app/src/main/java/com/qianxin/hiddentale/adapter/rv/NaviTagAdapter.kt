package com.qianxin.hiddentale.adapter.rv

import android.text.Html
import android.view.View
import android.view.ViewGroup
import com.qianxin.hiddentale.R
import com.qianxin.hiddentale.data.bean.wan.NaviBean
import com.qianxin.hiddentale.utils.CommonUtils
import com.qianxin.hiddentale.view.webview.WebViewActivity
import com.tuju.jetpackfirstdemo.base.baseadapter.BaseRecyclerViewAdapter
import com.tuju.jetpackfirstdemo.base.baseadapter.BaseRecyclerViewHolder
import kotlinx.android.synthetic.main.item_navi_tag.view.*

class NaviTagAdapter : BaseRecyclerViewAdapter<NaviBean.ArticleBean>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TagViewHolder(getView(parent, R.layout.item_navi_tag))

    inner class TagViewHolder(view: View) : BaseRecyclerViewHolder<NaviBean.ArticleBean>(view) {
        override fun onBaseBindViewHolder(bean: NaviBean.ArticleBean, position: Int) {
            view.tv_navi_tag.setTextColor(CommonUtils.randomColor())
            view.tv_navi_tag.text = Html.fromHtml(bean.title)
            view.tv_navi_tag.setOnClickListener {
                WebViewActivity.loadUrl(view.context, bean.link, bean.title)
            }
        }
    }
}