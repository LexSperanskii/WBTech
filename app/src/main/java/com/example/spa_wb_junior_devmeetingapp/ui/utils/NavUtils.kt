package com.example.spa_wb_junior_devmeetingapp.ui.utils

import com.example.spa_wb_junior_devmeetingapp.model.CommunityItem
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.GsonInstance
import java.net.URLDecoder

object NavUtils {

    private const val ENCODING_TYPE = "UTF-8"

    fun deserializeEvent(encodedJson: String?): EventItem {
        return encodedJson?.let {
            try {
                val eventJson = URLDecoder.decode(it, ENCODING_TYPE)
                GsonInstance.gson.fromJson(eventJson, EventItem::class.java)
            } catch (e: Exception) {
                EventItem()
            }
        } ?: EventItem()
    }

    fun deserializeCommunity(encodedJson: String?): CommunityItem {
        return encodedJson?.let {
            try {
                val communityJson = URLDecoder.decode(it, ENCODING_TYPE)
                GsonInstance.gson.fromJson(communityJson, CommunityItem::class.java)
            } catch (e: Exception) {
                CommunityItem()
            }
        } ?: CommunityItem()
    }
}