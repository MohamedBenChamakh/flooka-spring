package com.project.content.utils;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {


    public static void optimizeImage(MultipartFile file) throws IOException {
        final Path basePath = Paths.get("src/main/resources/images/");
        File source = convertMultipartFileToFile(file, basePath);
        BufferedImage bimg = ImageIO.read(source);
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        Thumbnails.of(source)
                .size(width, height)
                .outputFormat("jpg")
                .toFiles(Rename.NO_CHANGE);
    }

    public static boolean convertToMp4(MultipartFile input) {
        Path tmpPath = Path.of("src/main/resources/tmp/");
        Path path = Path.of("src/main/resources/videos/");
        File source = convertMultipartFileToFile(input, tmpPath);
        File target = new File(path + File.separator + input.getOriginalFilename());

        /* Step 2. Set Audio Attributes for conversion*/
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac");
        // here 64kbit/s is 64000
        audio.setBitRate(128000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);

        /* Step 3. Set Video Attributes for conversion*/
        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264");
        video.setX264Profile(VideoAttributes.X264_PROFILE.BASELINE);
        // Here 500 kbps video is 500000
        video.setBitRate(500000);
        // More the frames more quality and size, but keep it low based on devices like mobile
        video.setFrameRate(24);
      //  video.setSize(new VideoSize(400, 300));

        /* Step 4. Set Encoding Attributes*/
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp4");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        /* Step 5. Do the Encoding*/
        try {
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);
            return true;
        } catch (Exception e) {
            /*Handle here the video failure*/
            return false;
        }
    }

    private static File convertMultipartFileToFile(MultipartFile multipartFile, Path basePath) {
        File file = new File(basePath + File.separator + multipartFile.getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
