package steve.sample.vendi.error

import androidx.annotation.StringRes
import steve.sample.vendi.R

interface ErrorView {

    val titleRes: Int
        @StringRes get() = R.string.default_error_title

    val messageRes: Int
        @StringRes get() = R.string.default_error_message

    val primaryButtonText: Int
        @StringRes get() = R.string.primary_error_btn_text

    val secondaryButtonText: Int
        @StringRes get() = R.string.secondary_error_btn_text

    val primaryButtonAction: () -> Unit

    val secondaryButtonAction: () -> Unit
}