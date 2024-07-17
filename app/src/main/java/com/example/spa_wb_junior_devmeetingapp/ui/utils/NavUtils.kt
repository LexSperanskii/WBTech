package com.example.spa_wb_junior_devmeetingapp.ui.utils

import com.example.spa_wb_junior_devmeetingapp.data.mockData.MockCommunityItem
import com.example.spa_wb_junior_devmeetingapp.data.mockData.MockEventItem
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.GsonInstance
import java.net.URLDecoder

object NavUtils {

    private const val ENCODING_TYPE = "UTF-8"

    fun deserializeEvent(encodedJson: String?): MockEventItem {
        return encodedJson?.let {
            try {
                val eventJson = URLDecoder.decode(it, ENCODING_TYPE)
                GsonInstance.gson.fromJson(eventJson, MockEventItem::class.java)
            } catch (e: Exception) {
                MockEventItem()
            }
        } ?: MockEventItem()
    }

    fun deserializeCommunity(encodedJson: String?): MockCommunityItem {
        return encodedJson?.let {
            try {
                val communityJson = URLDecoder.decode(it, ENCODING_TYPE)
                GsonInstance.gson.fromJson(communityJson, MockCommunityItem::class.java)
            } catch (e: Exception) {
                MockCommunityItem()
            }
        } ?: MockCommunityItem()
    }
}