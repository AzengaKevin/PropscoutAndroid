package com.mysasse.propscout.ui.properties

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mysasse.propscout.data.models.Property
import com.mysasse.propscout.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PropertiesViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<Property>?>()

    val properties get() = _properties

    init {
        viewModelScope.launch {
            _properties.value = getProperties()
        }
    }

    private suspend fun getProperties(): List<Property>? {

        return withContext(Dispatchers.IO) {
            MyApi().getProperties().body()
        }
    }


}