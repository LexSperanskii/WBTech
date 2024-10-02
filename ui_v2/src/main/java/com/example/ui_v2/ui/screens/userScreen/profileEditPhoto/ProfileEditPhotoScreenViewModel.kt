package com.example.ui_v2.ui.screens.userScreen.profileEditPhoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.getClient.IInteractorGetClient
import com.example.domain.interactors.client.getClient.IInteractorLoadClient
import com.example.domain.interactors.client.setClientAvatar.IInteractorSetClientAvatar
import com.example.ui_v2.ui.utils.UiUtils.listOfIconsMOCK
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


internal data class ProfileEditPhotoScreenUiState(
    val avatar: String? = null,
    val isButtonSaveEnabled: Boolean = true,
)

internal class ProfileEditPhotoScreenViewModel(
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val setClientAvatar: IInteractorSetClientAvatar,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileEditPhotoScreenUiState())
    private val uiState: StateFlow<ProfileEditPhotoScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getProfileEditPhotoScreenUiStateFlow(): StateFlow<ProfileEditPhotoScreenUiState> = uiState

    fun onChangePhotoClick() {
        //TODO: исправить этот мок и удалить из utils
        _uiState.update {
            it.copy(
                avatar = listOfIconsMOCK.random()
            )
        }
    }

    fun onButtonSaveClick() {
        setClientAvatar.invoke(uiState.value.avatar)
    }

    private fun loadData() {
        loadClient.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        getClient.invoke().onEach { client ->
            _uiState.update {
                it.copy(
                    avatar = client.imageURL
                )
            }
        }.launchIn(viewModelScope)
    }
}