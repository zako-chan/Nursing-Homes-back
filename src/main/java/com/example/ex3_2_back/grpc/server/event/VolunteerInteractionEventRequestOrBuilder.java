// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package com.example.ex3_2_back.grpc.server.event;

public interface VolunteerInteractionEventRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:event.VolunteerInteractionEventRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 elderlyId = 1;</code>
   * @return The elderlyId.
   */
  int getElderlyId();

  /**
   * <code>int32 volunteerId = 2;</code>
   * @return The volunteerId.
   */
  int getVolunteerId();

  /**
   * <code>string imageUrl = 3;</code>
   * @return The imageUrl.
   */
  java.lang.String getImageUrl();
  /**
   * <code>string imageUrl = 3;</code>
   * @return The bytes for imageUrl.
   */
  com.google.protobuf.ByteString
      getImageUrlBytes();

  /**
   * <code>int32 cameraId = 4;</code>
   * @return The cameraId.
   */
  int getCameraId();
}
