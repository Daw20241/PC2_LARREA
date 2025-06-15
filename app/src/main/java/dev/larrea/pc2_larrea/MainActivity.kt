package dev.larrea.pc2_larrea


import dev.larrea.pc2_larrea.LoginActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.auth.FirebaseAuth
import dev.larrea.pc2_larrea.ui.screens.CurrencyConverterScreen
import dev.larrea.pc2_larrea.ui.theme.PC2_LARREATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        setContent {
            PC2_LARREATheme {
                CurrencyConverterScreen(user.uid)
            }
        }
    }
}
