package com.blannon_network.bshoping.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blannon_network.bshoping.R
import com.google.firebase.auth.PhoneAuthProvider

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SigningScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Login image"
        )

        PhoneNumberScreen ()
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                Toast.makeText(context, "Verification successful..", Toast.LENGTH_SHORT).show()
                loading.value = false
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(context, "Verification failed.. ${p0.message}", Toast.LENGTH_LONG)
                    .show()
                loading.value = false
            }

            override fun onCodeSent(
                verificationId: String,
                p1: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(verificationId, p1)
                verificationID.value = verificationId
                codeSent.value = true
                loading.value = false
            }
        }






    }
}