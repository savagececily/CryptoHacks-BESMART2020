package com.cryptohacks.overhead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarryOnActivityPt2 extends AppCompatActivity {
    static final int REQUEST_TAKE_PHOTO = 1;
    private Button takePhoto;
    private Button manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carry_on_pt2);

        takePhoto = (Button) findViewById(R.id.photo_button);
        takePhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // get permission
                if(true /*Access Granted*/){
                    dispatchTakePictureIntent();
                    // send image to Custom Vision for prediction
                    // Get Values for next activity
                }
            }
        });

        manual = (Button) findViewById(R.id.manual_button);
        manual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity(){
        Intent intent = new Intent(this, CarryOnActivityPt3.class);
        startActivity(intent);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public static async Task MakePredictionRequest(string imageFilePath)
    {
        var client = new HttpClient();

        // Request headers - replace this example key with your valid Prediction-Key.
        client.DefaultRequestHeaders.Add("Prediction-Key", "<Your prediction key>");

        // Prediction URL - replace this example URL with your valid Prediction URL.
        string url = "<Your prediction URL>";

        HttpResponseMessage response;

        // Request body. Try this sample with a locally stored image.
        byte[] byteData = GetImageAsByteArray(imageFilePath);

        using (var content = new ByteArrayContent(byteData))
        {
            content.Headers.ContentType = new MediaTypeHeaderValue("application/octet-stream");
            response = await client.PostAsync(url, content);
            Console.WriteLine(await response.Content.ReadAsStringAsync());
        }
    }

    private static byte[] GetImageAsByteArray(string imageFilePath)
    {
        FileStream fileStream = new FileStream(imageFilePath, FileMode.Open, FileAccess.Read);
        BinaryReader binaryReader = new BinaryReader(fileStream);
        return binaryReader.ReadBytes((int)fileStream.Length);
    }
}
}
}