package com.example.offzmi.repository.backend.models

import com.squareup.moshi.Moshi
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

internal class UserDtoTest {
    @Test
    internal fun checkResponse() {
        val userResponse = """
            {"id":"recocTGkklHkCXetE","createdTime":"2022-12-09T14:07:01.000Z","fields":{"role":"CONTRIBUTOR","id":42,"avatarBase64":"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\njlRLPRQCkggi/fxgP//Z","lastName":"Геращенко","rating":5,"verified":"TRUE","firstName":"Антон","position":"Журналист","company":"ТСН"}}
        """.trimIndent()
        val moshi = Moshi.Builder().build().adapter<UserDto>(UserDto::class.java)
        val user = moshi.fromJson(userResponse)
        assertEquals("recocTGkklHkCXetE", user!!.id )
        assertNotNull(user.fields.firstName)
    }
}