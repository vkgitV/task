package com.example.factorykt

import org.jetbrains.annotations.TestOnly
import java.nio.file.attribute.AclEntry

class Component private constructor(builder:Builder){// private constructor
var param1:String?=null
var param2:Int?=null
var param3:Boolean?=null


class Builder {
    private var param1: String? = null
    private var param2: Int? = null
    private var param3: Boolean? = null

    fun setParam1(param1: String) =
        apply { this.param1 = param1 } //function for each field to set the field value

    fun setParam2(param2: Int) = apply { this.param2 = param2 }
    fun setParam3(param3: Boolean) = apply { this.param3 = param3 }
    fun build() = Component(this)

    fun getParam1() = param1
    fun getParam2() = param2
    fun getParam3() = param3


}
init {
    param1 = builder.getParam1()
    param2 = builder.getParam2()
    param3 = builder.getParam3()
}
}
class  ComponentTest{
@TestOnly
fun builderTest(){
    val component:Component=Component.Builder()
        .setParam1("Some value")
        .setParam3(true)
        .build()
    println(component.param2)
    println(component.param1)
    println(component.param3)

//    Assertions.assertThat(component.param1).isEqualTo("Some value")
//    Assertions.assertThat(component.param2).isEqualTo(true)
//    Assertions.assetThat(component.param3).isEqualTo(null)
}

}


