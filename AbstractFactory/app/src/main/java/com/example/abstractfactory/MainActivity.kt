package com.baeldung.abstractfactory

import com.example.abstractfactory.Ak47
import com.example.abstractfactory.Crossbow
import com.example.abstractfactory.WeaponFactory
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test


internal class AbstractFactoryPatternUnitTest {

    @Test
    fun givenCrossbowFactory_whenBuildWeapon_thenCrossbowWeaponIsReturned() {

        val factory: WeaponFactory = Crossbow.Factory

        val crossbow = factory.buildWeapon()

        assertNotNull(crossbow)
        assertEquals("Using crossbow weapon", crossbow.use())
    }

    @Test
    fun givenKatanaFactory_whenBuildWeapon_thenKatanaWeaponIsReturned() {

        val factory: WeaponFactory = Ak47.Factory

        val Ak47 = factory.buildWeapon()

        assertNotNull(Ak47)
        assertEquals("Using Ak47 weapon", Ak47.use())
    }
}