package com.example.tonalitysearch2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tonalitysearch2.databinding.ActivityCalculadorBinding

class Calculador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind2= ActivityCalculadorBinding.inflate(layoutInflater)
        setContentView(bind2.root)
        var numeroacordes:Int=0
        var acorde:String=""
        var contador:Int=0
        var misacordes= arrayListOf<String>()
        bind2.ok.isEnabled=false
        var mimotor=Motor(misacordes)


        //inicialmente tendremos un alert dialog para darnos instrucciones
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Atención Músicos")
        builder.setMessage(R.string.ayuda)
        builder.setPositiveButton("ok"){
            dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
        }
        builder.show()


        bind2.volver.setOnClickListener {
            val intent2= Intent(this,MainActivity::class.java)
        }
        bind2.intro.setOnClickListener {
            bind2.ok.isEnabled=true
            numeroacordes=bind2.editTextNumber.text.toString().toInt()
            Toast.makeText(this, "inserte acorde",Toast.LENGTH_LONG).show()



        }
        bind2.ok.setOnClickListener {
            //el boton ok controlará el contador
            var numeroref:Int=bind2.editTextNumber.text.toString().toInt()
            acorde = bind2.visor.text.toString()
            //si metemos un acorde vacio se nos quejará
            if(acorde==""){
                builder.setTitle("Atención Músicos")
                builder.setMessage("ha introducido un acorde vacio")
                builder.setPositiveButton("ok"){
                    dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                }
                builder.show()
            }else{
                //de lo contrario hara su trabajo el contador y el usuario vera como disminuyen los acordes a insertar
                contador++
                numeroref--
                bind2.editTextNumber.setText(numeroref.toString())
                misacordes.add(acorde)
                bind2.visor.setText("")
                if(contador==numeroacordes){
                    Toast.makeText(this, "ha finalizado",Toast.LENGTH_LONG).show()
                    bind2.ok.isEnabled=false
                    bind2.editTextNumber.setText("")

                }else{
                    Toast.makeText(this, "siguiente acorde",Toast.LENGTH_LONG).show()
                }
            }

        }//todos nuestros botones
        bind2.botondo2.setOnClickListener {
            bind2.visor.setText("do")
        }
        bind2.botonre2.setOnClickListener {
            bind2.visor.setText("re")
        }
        bind2.botonmi2.setOnClickListener {
            bind2.visor.setText("mi")
        }
        bind2.botonfa2.setOnClickListener {
            bind2.visor.setText("fa")
        }
        bind2.botonsol2.setOnClickListener {
            bind2.visor.setText("sol")
        }
        bind2.botonla2.setOnClickListener {
            bind2.visor.setText("la")
        }

        bind2.botonsi2.setOnClickListener {
            bind2.visor.setText("si")
        }

        bind2.mayor.setOnClickListener {
            bind2.visor.append(" mayor")
        }
        bind2.boton72.setOnClickListener {
            bind2.visor.append("7")
        }
        bind2.sostenido.setOnClickListener {
            bind2.visor.append("#")

        }
        bind2.bemol.setOnClickListener {
            bind2.visor.append("b")
        }
        bind2.menor.setOnClickListener {
            bind2.visor.append(" menor")
        }
        bind2.boton5.setOnClickListener {
            bind2.visor.append("5")
        }
        bind2.volver.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        bind2.calcular.setOnClickListener {
            mimotor.Calculando(misacordes)
            //aqui hemos usado la instancia motor
            //dependiendo de lo que nos devuelva el metodo lanzara uno u otro Alert Dialog
            Log.d("TAG","LOS VALORES SON: $misacordes")
            when {
                mimotor.Calculando(misacordes)==1 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidado)
                    builder.setView(R.layout.doyla)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                    //bind2.visor.setText(getString(R.string.tonalidado))
                }
                mimotor.Calculando(misacordes)==2 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidasol)
                    builder.setView(R.layout.solymi)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()



                }
                mimotor.Calculando(misacordes)==3 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidare)
                    builder.setView(R.layout.reysi)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==4 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidala)
                    builder.setView(R.layout.layfasos)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==5 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidami)
                    builder.setView(R.layout.miydosos)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()


                }
                mimotor.Calculando(misacordes)==6 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidasi)
                    builder.setView(R.layout.siysol)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==7 -> {
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidafa)
                    builder.setView(R.layout.fayre)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==8 ->{
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidasib)
                    builder.setView(R.layout.sibysol)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==9 ->{
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage(R.string.tonalidamib)
                    builder.setView(R.layout.mibydo)
                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()

                }
                mimotor.Calculando(misacordes)==10 ->{
                val builder= AlertDialog.Builder(this)
                builder.setTitle("Atención Músicos")
                builder.setMessage(R.string.tonalidalab)
                builder.setView(R.layout.labyfa)
                builder.setPositiveButton("ok"){
                    dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                }
                builder.show()

            }

                mimotor.Calculando(misacordes)==0 ->{
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("Atención Músicos")
                    builder.setMessage("no se encuentra tonalidad, revise los acordes, y recuerde que el sitema solo soporta hasta acordes septimas")

                    builder.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder.show()
                }
            }
            contador=0
            misacordes.clear()

        }
        bind2.delete.setOnClickListener {
            bind2.visor.setText("")
            bind2.editTextNumber.setText("")
            contador=0
            misacordes.clear()
            bind2.ok.isEnabled=false
        }







    }
}