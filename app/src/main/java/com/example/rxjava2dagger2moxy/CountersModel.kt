package com.example.rxjava2dagger2moxy

class CountersModel (private val mapper: EnumToIndexMapper) {

    private val counters = mutableListOf(0,0,0)

    fun getCurrent(enum: ButtonTypeEnum): Int {
        val index = mapper.mapEnumToIndex(enum)
        return counters[index]
    }

    fun next(enum:ButtonTypeEnum): Int {
        val index = mapper.mapEnumToIndex(enum)
        counters[index]++
        return getCurrent(enum)
    }
}

