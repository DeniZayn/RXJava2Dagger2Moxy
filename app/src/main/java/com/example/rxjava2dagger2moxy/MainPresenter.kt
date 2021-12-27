package com.example.rxjava2dagger2moxy

class MainPresenter(private val view: MainView) {

    private val mapper = EnumToIndexMapper()
    private val model = CountersModel(mapper)

    fun setInitialValue() {
        val countersCount = ButtonTypeEnum.values().size - 1
        for (index in 0.. countersCount) {
            val enumValue = mapper.mapIndexToEnum(index)
            val uiModel = ButtonUiModel(enumValue, model.getCurrent(enumValue).toString())
            view.setButtonText(uiModel)
        }
    }
    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        view.setButtonText(uiModel)
    }
}