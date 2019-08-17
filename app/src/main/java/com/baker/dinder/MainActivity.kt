package com.baker.dinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var dogImage: ImageView
    private lateinit var breedTxt: TextView
    private lateinit var descriptionTxt: TextView

    private val dogs = generateDogs()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dogImage = findViewById(R.id.dogImage)
        breedTxt = findViewById(R.id.breedTxt)
        descriptionTxt = findViewById(R.id.descriptionTxt)

        showDog(dogs[index])

    }

    fun like (view: View){
        Toast.makeText(this@MainActivity, "Liked", Toast.LENGTH_SHORT).show()
        index += 1

        if (index == dogs.size) {
            index = 0
        }
        showDog(dogs[index])
    }

    fun dislike (view: View){
        Toast.makeText(this@MainActivity, "Disliked", Toast.LENGTH_SHORT).show()
        index += 1

        if (index == dogs.size) {
            index = 0
        }
        showDog(dogs[index])
    }

    private fun generateDogs():List<Dog> {
        return arrayListOf(
            Dog("Black Labrador / German Shepherd mix", R.drawable.black_lab_germ_shep_mix,
                "Loyal, loving and a big softie."),
            Dog("Chocolate Labrador", R.drawable.choc_lab, "Family favourite and quick learner."),
            Dog("Dalmation", R.drawable.dalmation, "Mischievous but stunning!"),
            Dog("German Shepherd", R.drawable.germ_shep, "Faithful protector & easy to train."),
            Dog("Great Dane", R.drawable.great_dane, "A massive playful softie!"),
            Dog("Husky", R.drawable.husky, "Guard dog & companion."),
            Dog("Poodle", R.drawable.poodle, "Alert, instinctive and loyal."),
            Dog("Whippet", R.drawable.whippet, "Fast, sleek, stubborn and polite.")
        )
    }

    private fun showDog(dog: Dog){
        dogImage.setImageResource(dog.image)
        breedTxt.text = dog.breed
        descriptionTxt.text = dog.description
    }

    data class Dog(val breed: String, val image: Int, val description: String)
}
