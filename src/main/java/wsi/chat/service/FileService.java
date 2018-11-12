package wsi.chat.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileService {
    private final Path storageLocation = Paths.get(".");

    public String storeFile(MultipartFile file) throws IOException {
        String filename =  StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation = storageLocation.resolve(filename);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public Resource loadFile(String filename) {
        try {
            Path filePath = storageLocation.resolve(filename).normalize();
            Resource r = new UrlResource(filePath.toUri());
            if (r.exists()) return r;
            else throw new RuntimeException("File not found");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error reading file");
        }
    }


}
