// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package com.example.ex3_2_back.grpc.server.event;

public interface EventServerResopnseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:event.EventServerResopnse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>int32 code = 2;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <code>string data = 3;</code>
   * @return The data.
   */
  java.lang.String getData();
  /**
   * <code>string data = 3;</code>
   * @return The bytes for data.
   */
  com.google.protobuf.ByteString
      getDataBytes();
}
