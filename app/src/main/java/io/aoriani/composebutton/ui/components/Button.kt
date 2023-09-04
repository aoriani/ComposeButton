package io.aoriani.composebutton.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseInCirc
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.aoriani.composebutton.ui.theme.ButtonBackgroundDisabled
import io.aoriani.composebutton.ui.theme.ButtonBackgroundHovered
import io.aoriani.composebutton.ui.theme.ButtonBackgroundNormal
import io.aoriani.composebutton.ui.theme.ButtonBackgroundPressed
import io.aoriani.composebutton.ui.theme.ButtonBorderFocused
import io.aoriani.composebutton.ui.theme.ButtonBorderNormal
import io.aoriani.composebutton.ui.theme.ButtonForegroundDisabled
import io.aoriani.composebutton.ui.theme.ButtonForegroundHovered
import io.aoriani.composebutton.ui.theme.ButtonForegroundNormal
import io.aoriani.composebutton.ui.theme.ComposeButtonTheme
import io.aoriani.composebutton.ui.theme.MontserratFont

@SuppressLint("ComposableNaming")
@Composable
private fun drawButton(
    text: String,
    icon: ImageVector?,
    backgroundColor: Color,
    foregroundColor: Color,
    borderColor: Color,
    shape: Shape,
    iconSize: Dp,
    borderSize: Dp,
    spacing: Dp,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = borderSize,
                color = borderColor,
                shape = shape
            )
            .background(
                color = backgroundColor,
                shape = shape
            )
            .padding(paddings)
            .defaultMinSize(minWidth = minWidth, minHeight = minHeight)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = foregroundColor,
                modifier = Modifier.size(iconSize)
            )
            Spacer(modifier = Modifier.width(spacing))
        }
        Text(text = text, color = foregroundColor, style = textStyle)
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true, name = "Icon")
@Composable
internal fun drawButtonPreview() {
    ComposeButtonTheme {
        Box(Modifier.padding(16.dp)) {
            drawButton(
                text = "Button",
                icon = Icons.Default.AccountCircle,
                backgroundColor = Color.White,
                foregroundColor = Color.Black,
                borderColor = Color.Black,
                shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
                iconSize = 32.dp,
                borderSize = 3.dp,
                spacing = 8.dp,
                minWidth = 60.dp,
                minHeight = 48.dp,
                paddings = PaddingValues(all = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp)
            )
        }
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true, name = "No Icon")
@Composable
internal fun drawButtonNoIconPreview() {
    ComposeButtonTheme {
        Box(Modifier.padding(16.dp)) {
            drawButton(
                text = "Button",
                icon = null,
                backgroundColor = Color.White,
                foregroundColor = Color.Black,
                borderColor = Color.Black,
                shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
                iconSize = 32.dp,
                borderSize = 3.dp,
                spacing = 8.dp,
                minWidth = 60.dp,
                minHeight = 48.dp,
                paddings = PaddingValues(all = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp)
            )
        }
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true,  name = "Long Text")
@Composable
internal fun drawButtonLongTextPreview() {
    ComposeButtonTheme {
        Box(Modifier.padding(16.dp)) {
            drawButton(
                text = "Very long text in button",
                icon = Icons.Outlined.Person,
                backgroundColor = Color.White,
                foregroundColor = Color.Black,
                borderColor = Color.Black,
                shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
                iconSize = 32.dp,
                borderSize = 3.dp,
                spacing = 8.dp,
                minWidth = 60.dp,
                minHeight = 48.dp,
                paddings = PaddingValues(all = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp)
            )
        }
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true,  name = "RTL", locale = "fa")
@Composable
internal fun drawButtonBidirPreview() {
    ComposeButtonTheme {
        Box(Modifier.padding(16.dp)) {
            drawButton(
                text = "\uD802\uDD03\uD802\uDD01\uD802\uDD13\uD802\uDD0C",
                icon = Icons.Outlined.Person,
                backgroundColor = Color.White,
                foregroundColor = Color.Black,
                borderColor = Color.Black,
                shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
                iconSize = 32.dp,
                borderSize = 3.dp,
                spacing = 8.dp,
                minWidth = 60.dp,
                minHeight = 48.dp,
                paddings = PaddingValues(all = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp)
            )
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
private fun animateButton(
    text: String,
    icon: ImageVector?,
    backgroundColor: Color,
    foregroundColor: Color,
    borderColor: Color,
    shape: Shape,
    iconSize: Dp,
    borderSize: Dp,
    spacing: Dp,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle,
    animationDuration: Int,
    animationEasing: Easing,
    modifier: Modifier = Modifier
) {
    val colorAnimationSpec =
        tween<Color>(durationMillis = animationDuration, easing = animationEasing)
    val animatedBorderColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = borderColor,
        label = "border"
    )
    val animatedBackgroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = backgroundColor,
        label = "background"
    )
    val animatedForegroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = foregroundColor,
        label = "foreground"
    )

    val localModifier = modifier.animateContentSize(
        animationSpec = tween(
            durationMillis = animationDuration,
            easing = animationEasing
        )
    )
    drawButton(
        text = text,
        icon = icon,
        backgroundColor = animatedBackgroundColor,
        foregroundColor = animatedForegroundColor,
        borderColor = animatedBorderColor,
        shape = shape,
        iconSize = iconSize,
        borderSize = borderSize,
        spacing = spacing,
        minWidth = minWidth,
        minHeight = minHeight,
        paddings = paddings,
        textStyle = textStyle,
        modifier = localModifier
    )
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
@Composable
internal fun animateButtonPreview() {
    ComposeButtonTheme {
        Box(Modifier.padding(16.dp)) {
            animateButton(
                text = "Button",
                icon = Icons.Default.AccountCircle,
                backgroundColor = Color.White,
                foregroundColor = Color.Black,
                borderColor = Color.Black,
                shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
                iconSize = 32.dp,
                borderSize = 3.dp,
                spacing = 8.dp,
                minWidth = 60.dp,
                minHeight = 48.dp,
                paddings = PaddingValues(all = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
                animationDuration = 250,
                animationEasing = EaseInBack
            )
        }
    }
}

object ButtonInteractionState {
    @JvmStatic
    val HOVER = 1.shl(0)

    @JvmStatic
    val PRESSED = 1.shl(1)

    @JvmStatic
    val FOCUSED = 1.shl(2)
}

interface ButtonColors {
    @Stable
    @Composable
    fun borderColor(interactionState: Int, enabled: Boolean): State<Color>

    @Stable
    @Composable
    fun foregroundColor(interactionState: Int, enabled: Boolean): State<Color>

    @Stable
    @Composable
    fun backgroundColor(interactionState: Int, enabled: Boolean): State<Color>
}

@Immutable
interface ButtonSizes {
    val iconSize: Dp
    val borderSize: Dp
    val contentPadding: PaddingValues
    val spacing: Dp
    val minWidth: Dp
    val minHeight: Dp
}

@Immutable
interface ButtonAnimation {
    val duration: Int
    val easing: Easing
}

@SuppressLint("ComposableNaming")
@Composable
private fun stateButton(
    text: String,
    onClick: () -> Unit,
    icon: ImageVector?,
    colors: ButtonColors,
    sizes: ButtonSizes,
    shape: Shape,
    textStyle: TextStyle,
    animation: ButtonAnimation,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    var interactionState = 0
    if (isHovered) interactionState = interactionState.or(ButtonInteractionState.HOVER)
    if (isPressed) interactionState = interactionState.or(ButtonInteractionState.PRESSED)
    if (isFocused) interactionState = interactionState.or(ButtonInteractionState.FOCUSED)

    val currentModifier = modifier.clickable(
        interactionSource = interactionSource,
        indication = null,
        enabled = enabled,
        onClick = onClick,
        role = Role.Button
    )

    val backgroundColor = colors.backgroundColor(interactionState, enabled).value
    val foregroundColor = colors.foregroundColor(interactionState, enabled).value
    val borderColor = colors.borderColor(interactionState, enabled).value

    animateButton(
        text = text,
        icon = icon,
        backgroundColor = backgroundColor,
        foregroundColor = foregroundColor,
        borderColor = borderColor,
        shape = shape,
        iconSize = sizes.iconSize,
        borderSize = sizes.borderSize,
        spacing = sizes.spacing,
        minWidth = sizes.minWidth,
        minHeight = sizes.minHeight,
        paddings = sizes.contentPadding,
        textStyle = textStyle,
        animationDuration = animation.duration,
        animationEasing = animation.easing,
        modifier = currentModifier
    )
}

private infix fun Int.has(bit: Int) = this.and(bit) != 0

object ButtonDefaults {
    val colors = object : ButtonColors {
        @Composable
        override fun borderColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> ButtonForegroundDisabled
                    interactionState has ButtonInteractionState.FOCUSED -> ButtonBorderFocused
                    interactionState has ButtonInteractionState.HOVER -> ButtonForegroundHovered
                    else -> ButtonBorderNormal
                }
            )
        }

        @Composable
        override fun foregroundColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> ButtonForegroundDisabled
                    interactionState has ButtonInteractionState.HOVER -> ButtonForegroundHovered
                    else -> ButtonForegroundNormal
                }
            )
        }

        @Composable
        override fun backgroundColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> ButtonBackgroundDisabled
                    interactionState has ButtonInteractionState.PRESSED -> ButtonBackgroundPressed
                    interactionState has ButtonInteractionState.HOVER -> ButtonBackgroundHovered
                    else -> ButtonBackgroundNormal
                }
            )
        }
    }

    val sizes = object : ButtonSizes {
        override val iconSize = 32.dp
        override val borderSize = 3.dp
        override val contentPadding = PaddingValues(all = 16.dp)
        override val spacing = 8.dp
        override val minWidth = 60.dp
        override val minHeight = 48.dp

    }

    val animation = object : ButtonAnimation {
        override val duration = 250
        override val easing = EaseInCirc
    }

    val shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30)

    val textStyle = TextStyle(
        fontFamily = MontserratFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    )
}

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.colors,
    sizes: ButtonSizes = ButtonDefaults.sizes,
    shape: Shape = ButtonDefaults.shape,
    textStyle: TextStyle = ButtonDefaults.textStyle,
    animation: ButtonAnimation = ButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    stateButton(
        text,
        onClick,
        icon,
        colors,
        sizes,
        shape,
        textStyle,
        animation,
        modifier,
        enabled,
        interactionSource
    )
}

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun ButtonPreview() {
    ComposeButtonTheme {
        var showIcon by remember { mutableStateOf(true) }
        Box(modifier = Modifier.padding(24.dp)) {
            Button(
                text = "Button Text",
                onClick = { showIcon = !showIcon },
                icon = if (showIcon) Icons.Default.Home else null
            )
        }
    }
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun ButtonDisabledPreview() {
    ComposeButtonTheme {
        var showIcon by remember { mutableStateOf(true) }
        Box(modifier = Modifier.padding(24.dp)) {
            Button(
                text = "Button Text",
                onClick = { showIcon = !showIcon },
                icon = if (showIcon) Icons.Default.Home else null,
                enabled = false
            )
        }
    }
}
