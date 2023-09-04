package io.aoriani.composebutton.ui.components

import android.os.Build
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
class ButtonKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `When button is enabled tapping it will cause onClick to be called`() {
        val buttonText = "Button"
        var wasClicked = false
        composeTestRule.setContent {
            Button(text = buttonText, onClick = { wasClicked = true })
        }

        composeTestRule.onNodeWithText(buttonText).performClick()
        assertTrue(wasClicked)
    }

    @Test
    fun `When button is disabled tapping it will not cause onClick to be called`() {
        val buttonText = "Button"
        var wasClicked = false
        composeTestRule.setContent {
            Button(text = buttonText, onClick = { wasClicked = true }, enabled = false)
        }

        composeTestRule.onNodeWithText(buttonText).performClick()
        assertFalse(wasClicked)
    }
}