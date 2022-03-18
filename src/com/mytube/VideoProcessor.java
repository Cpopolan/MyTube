package com.mytube;

public class VideoProcessor {

    private VideoEncoder encoder;
    private VideoDatabase database;
    private EmailService notificationService;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, EmailService notificationService) {
        this.encoder = encoder;
        this.database = database;
        this.notificationService = notificationService;
    }
    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.sendEmail(video.getUser());
    }
}

