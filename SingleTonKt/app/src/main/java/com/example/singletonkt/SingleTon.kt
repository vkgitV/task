package com.example.singletonkt

object SingleTon {
     val SingleTon:User by lazy {
          User("vinaylucky077@gmail.com","vinay","image.png")
     }
}

 class User (
      val email:String?=null,
      val  username:String?=null,
      val image:String?=null)
 {
      override fun toString(): String {
           return "User(email=$email,username=$username,image=$image)"
      }
}
