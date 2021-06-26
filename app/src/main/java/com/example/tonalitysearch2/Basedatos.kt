package com.example.tonalitysearch2

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tonalitysearch2.databinding.ActivityBasededatosBinding

class Basedatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind3=ActivityBasededatosBinding.inflate(layoutInflater)
        setContentView(bind3.root)


            //el codigo comienza lanzando un Alert Dialog informando de donde se encuentra el usuario
            if(bind3.tabla1.isChecked){


            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Atencion Músicos")
            builder2.setMessage("introduzca el codigo de cancion en el campo codigo, el campo cancion en el campo cancion, y con el teclado" +
                    "los acordes separados de espacios entre ellos")
            builder2.setPositiveButton("ok"){
                dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
            }
            builder2.show()

                bind3.tabla1.setOnClickListener {
                    builder2.setTitle("Atencion Músicos")
                    builder2.setMessage("introduzca el codigo de cancion en el campo codigo, el campo cancion en el campo cancion, y con el teclado " +
                            "los acordes separados de espacios entre ellos")
                    builder2.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder2.show()
                    //"introduzca el codigo de cancion en el campo codigo, el autor en el campo autor, y el" +
                    //                            "codigo autor en el campo codigo autor"

                }
                bind3.tabla2.setOnClickListener {
                    builder2.setTitle("Atencion ")
                    builder2.setMessage("introduzca el codigo de cancion en el campo codigo, el autor en el campo autor, y el" +
                            "codigo autor en el campo codigo autor")
                    builder2.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder2.show()

                }
                bind3.tabla3.setOnClickListener {
                    builder2.setTitle("Atencion Músicos")
                    builder2.setMessage("introduzca codigo de cancion en el campo codigo, y tonalidad si la conoce en el recuadro mas grande")
                    builder2.setPositiveButton("ok"){
                        dialog,wich -> Toast.makeText(applicationContext,"ok", Toast.LENGTH_LONG).show()
                    }
                    builder2.show()

                }//para grabar
                bind3.grabar.setOnClickListener {
                    val admin = Cancionyacordes(this,"Canciones", null, 1)
                    if(bind3.tabla1.isChecked){
                        val bd = admin.writableDatabase
                        val registro = ContentValues()
                        registro.put("codigo", bind3.editcodigo.getText().toString())
                        //filas.add(registro.toString())
                        registro.put("cancion",bind3.editcancion.getText().toString())
                        //filas.add(registro.toString())
                        registro.put("acordes", bind3.visor2.getText().toString())
                        //filas.add(registro.toString())
                        //val tabla1lista= ArrayList(bind3.editcodigo.getText().toString(),bind3.editcancion.getText().toString(),bind3.visor2.getText().toString())
                        //registrotabla1.add(bind3.editcodigo.getText().toString(),bind3.editcancion.getText().toString(),bind3.visor2.getText().toString())
                        bd.insert("tabla1", null, registro)
                        bd.close()
                        bind3.editcodigo.setText("")
                        bind3.editcancion.setText("")
                        bind3.visor2.setText("")
                        Toast.makeText(this, "Se cargaron los datos en tabla1, relativos a codigo, cancion y acordes", Toast.LENGTH_SHORT).show()
                        



                    }
                    if(bind3.tabla2.isChecked){
                        val bd=admin.writableDatabase
                        val registro = ContentValues()
                        registro.put("codigo", bind3.editcodigo.getText().toString())

                        registro.put("autor",bind3.editautor.getText().toString())
                        registro.put("codigoautor", bind3.editcodigoautor.getText().toString())
                        bd.insert("tabla2", null, registro)
                        bd.close()
                        bind3.editcodigo.setText("")
                        bind3.editautor.setText("")
                        bind3.editcodigoautor.setText("")
                        Toast.makeText(this, "Se cargaron los datos en tabla2, relativos a codigo, autor y codigo de autor", Toast.LENGTH_SHORT).show()
                    }
                    if(bind3.tabla3.isChecked){
                        val bd=admin.writableDatabase
                        val registro = ContentValues()
                        registro.put("codigo",bind3.editcodigo.getText().toString())
                        registro.put("cancion",bind3.editcancion.getText().toString())
                        registro.put("tonalidad",bind3.visor2.getText().toString())
                        bd.insert("tabla3", null, registro)
                        bd.close()
                        bind3.editcodigo.setText("")
                        bind3.editautor.setText("")
                        bind3.editcodigoautor.setText("")
                        Toast.makeText(this, "Se cargaron los datos en tabla2, relativos a codigo, autor y codigo de autor", Toast.LENGTH_SHORT).show()

                    }
                }
                bind3.volver4.setOnClickListener {
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                //para listar cada registro
                bind3.listar.setOnClickListener {
                    val admin = Cancionyacordes(this,"Canciones", null, 1)

                    if(bind3.tabla1.isChecked){
                        val bd = admin.writableDatabase
                        val fila = bd.rawQuery("select codigo,cancion,acordes from tabla1 where codigo=${bind3.editcodigo.text.toString()}", null)
                        if (fila.moveToFirst()) {
                            bind3.editcodigo.setText(fila.getString(0))
                            bind3.editcancion.setText(fila.getString(1))
                            bind3.visor2.setText(fila.getString(2))
                        }else{
                            Toast.makeText(this, "No existe ninguna cancion con dicho código",  Toast.LENGTH_SHORT).show()
                            bd.close()

                        }


                    }


                    if(bind3.tabla2.isChecked){

                        val bd = admin.writableDatabase
                        val fila=bd.rawQuery("select codigo_FK,autor,codigoautor from tabla2 where codigoautor=${bind3.editcodigoautor.text.toString()}", null)
                        if(fila.moveToFirst()){
                            bind3.editcodigo.setText(fila.getString(0))
                            bind3.editautor.setText(fila.getString(1))
                            bind3.editcodigoautor.setText(fila.getString(2))

                        }else{
                            Toast.makeText(this, "No existe ninguna cancion con dicho código",  Toast.LENGTH_SHORT).show()
                            bd.close()

                        }

                    }
                    if(bind3.tabla3.isChecked){

                        val bd = admin.writableDatabase
                        val fila=bd.rawQuery("select codigo,cancion, tonalidad from tabla3 where codigo=${bind3.editcodigo.text.toString()}", null)
                        if(fila.moveToFirst()){
                            bind3.editcodigo.setText(fila.getString(0))
                            bind3.editcancion.setText(fila.getString(1))
                            bind3.visor2.setText(fila.getString(2))

                        }else{
                            Toast.makeText(this, "No existe ninguna cancion con dicho código",  Toast.LENGTH_SHORT).show()
                            bd.close()

                        }

                    }


                }//para borrar
                bind3.borrar.setOnClickListener {
                    if(bind3.tabla1.isChecked){

                        val admin = Cancionyacordes(this, "Canciones", null, 1)
                            val bd = admin.writableDatabase
                            val cant = bd.delete("tabla1", "codigo=${bind3.editcodigo.text.toString()}", null)
                            bd.close()
                            bind3.editcodigo.setText("")
                            bind3.editcancion.setText("")
                            bind3.visor2.setText("")
                            if (cant == 1)
                                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
                            else
                                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()

                    }
                    if(bind3.tabla2.isChecked){

                        val admin = Cancionyacordes(this, "Canciones", null, 1)
                        val bd = admin.writableDatabase
                        val cant = bd.delete("tabla2", "codigoautor=${bind3.editcodigoautor.text.toString()}", null)
                        bd.close()
                        bind3.editcodigo.setText("")
                        bind3.editcancion.setText("")
                        bind3.visor2.setText("")
                        if (cant == 1)
                            Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()

                    }
                    if(bind3.tabla3.isChecked){

                        val admin = Cancionyacordes(this, "Canciones", null, 1)
                        val bd = admin.writableDatabase
                        val cant = bd.delete("tabla3", "codigo=${bind3.editcodigo.text.toString()}", null)
                        bd.close()
                        bind3.editcodigo.setText("")
                        bind3.editcancion.setText("")
                        bind3.visor2.setText("")
                        if (cant == 1)
                            Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()

                    }


                }

                bind3.limpiar.setOnClickListener {
                    bind3.visor2.setText("")
                    bind3.editcodigo.setText("")
                    bind3.editcodigoautor.setText("")
                    bind3.editcancion.setText("")
                    bind3.editautor.setText("")
                }
        }
    }
}