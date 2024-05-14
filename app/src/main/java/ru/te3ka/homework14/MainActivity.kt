package ru.te3ka.homework14

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.te3ka.homework14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newUser()
        binding.buttonNewUser.setOnClickListener {
            newUser()
        }
    }

    private fun newUser() {
        RetrofitInstance.randomUserService
            .getRandomUser().enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    val user = response.body()?.results?.first()

                    if (user != null) {
                        Picasso.get().load(user.picture.large).into(binding.imageUser)

                        binding.textTitle.text = "${user.name.title}"
                        binding.textFirstName.text = " ${user.name.first} "
                        binding.textLastName.text = " ${user.name.last}"

                        binding.textDob.text = "${user.dob.date} "
                        binding.textAge.text = " ${user.dob.age} "
                        binding.textGender.text = "${user.gender}"

                        binding.textCountry.text = user.location.country
                        binding.textState.text = user.location.state
                        binding.textCity.text = user.location.city

                        binding.textPhoneNumber.text = " ${user.phone}"
                        binding.textCellNumber.text = " ${user.cell}"
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.e("Network", "Error", t)
                }
            })
    }
}