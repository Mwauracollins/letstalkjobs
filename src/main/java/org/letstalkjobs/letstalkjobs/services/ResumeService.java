package org.letstalkjobs.letstalkjobs.services;

import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.entities.Resume;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ResumeService {

    public Resume uploadResume(Applicant applicant, MultipartFile file){
        try {
            File convertedFile = convertMultipartFileToFile(file);

            Resume resume = new Resume();
            resume.setApplicant(applicant);
            resume.setDocument(convertedFile);

            return resume;

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private @NotNull File convertMultipartFileToFile(
            MultipartFile file
    ) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        file.transferTo(convertedFile);
        return convertedFile;

    }
}
