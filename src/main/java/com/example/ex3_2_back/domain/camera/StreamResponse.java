package com.example.ex3_2_back.domain.camera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StreamResponse {
    private int code;
    private String server;
    private List<Stream> streams;

    @Data
    public static class Stream {
        private String id;
        private String name;
        private String vhost;
        private String app;
        private long liveMs;
        private int clients;
        private int frames;
        private int sendBytes;
        private int recvBytes;
        private Kbps kbps;
        private Publish publish;
        private Video video;
        private Audio audio;

        // Getters and setters

        @Data
        public static class Kbps {
            private int recv30s;
            private int send30s;

        }

        @Data
        public static class Publish {
            private boolean active;
            private String cid;
        }

        @Data
        public static class Video {
            private String codec;
            private String profile;
            private String level;
            private int width;
            private int height;
        }

        @Data
        public static class Audio {
            private String codec;
            private int sampleRate;
            private int channel;
            private String profile;
        }
    }
}
