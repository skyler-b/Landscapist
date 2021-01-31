/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("CircularRevealedImage")
@file:JvmMultifileClass

package com.skydoves.landscapist

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ImagePainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

/**
 * CircularRevealedImage is an image composable for animating a clipping circle to reveal when loading an image.
 *
 * @param bitmap an image bitmap for loading for the content.
 * @param modifier adjust the drawing image layout or drawing decoration of the content.
 * @param imagePainter an image painter to draw an [ImageBitmap] into the provided canvas.
 * @param alignment alignment parameter used to place the loaded [ImageBitmap] in the
 * given bounds defined by the width and height.
 * @param contentScale parameter used to determine the aspect ratio scaling to be
 * used if the bounds are a different size from the intrinsic size of the loaded [ImageBitmap].
 * @param contentDescription The content description used to provide accessibility to describe the image.
 * @param alpha an alpha value to apply for the image when it is rendered onscreen.
 * @param colorFilter colorFilter to apply for the image when it is rendered onscreen.
 * @param circularRevealedEnabled a conditional value for enabling or not the circular revealing animation.
 * @param circularRevealedDuration milli-second times from start to finish animation.
 */
@Composable
fun CircularRevealedImage(
  bitmap: ImageBitmap,
  modifier: Modifier = Modifier,
  imagePainter: Painter = ImagePainter(bitmap),
  alignment: Alignment = Alignment.Center,
  contentScale: ContentScale = ContentScale.Crop,
  contentDescription: String?,
  alpha: Float = DefaultAlpha,
  colorFilter: ColorFilter? = null,
  circularRevealedEnabled: Boolean = false,
  circularRevealedDuration: Int = DefaultCircularRevealedDuration
) {
  Image(
    painter = if (circularRevealedEnabled) {
      imagePainter.circularReveal(bitmap, circularRevealedDuration)
    } else {
      imagePainter
    },
    modifier = modifier,
    alignment = alignment,
    contentDescription = contentDescription,
    contentScale = contentScale,
    colorFilter = colorFilter,
    alpha = alpha
  )
}

/** a definition of the default circular revealed animations duration. */
const val DefaultCircularRevealedDuration = 350
