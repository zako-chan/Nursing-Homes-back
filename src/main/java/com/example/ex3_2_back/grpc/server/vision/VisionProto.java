// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vision.proto

package com.example.ex3_2_back.grpc.server.vision;

public final class VisionProto {
  private VisionProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vision_FaceCollectionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vision_FaceCollectionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vision_RemoveUrlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vision_RemoveUrlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vision_CommonResopnse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vision_CommonResopnse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vision_StartVisonServiceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vision_StartVisonServiceRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014vision.proto\022\006vision\"p\n\025FaceCollection" +
      "Request\022\017\n\007user_id\030\001 \001(\005\022\020\n\010identity\030\002 \001" +
      "(\t\022\020\n\010username\030\003 \001(\t\022\020\n\010pull_url\030\004 \001(\t\022\020" +
      "\n\010push_url\030\005 \001(\t\"G\n\020RemoveUrlRequest\022\017\n\007" +
      "user_id\030\001 \001(\005\022\020\n\010identity\030\002 \001(\t\022\020\n\010usern" +
      "ame\030\003 \001(\t\"/\n\016CommonResopnse\022\014\n\004code\030\001 \001(" +
      "\005\022\017\n\007message\030\002 \001(\t\"c\n\030StartVisonServiceR" +
      "equest\022\021\n\tcamera_id\030\001 \001(\005\022\020\n\010pull_url\030\002 " +
      "\001(\t\022\020\n\010push_url\030\003 \001(\t\022\020\n\010model_id\030\004 \001(\0052" +
      "\346\001\n\rVisionService\022G\n\016FaceCollection\022\035.vi" +
      "sion.FaceCollectionRequest\032\026.vision.Comm" +
      "onResopnse\022=\n\tRemoveUrl\022\030.vision.RemoveU" +
      "rlRequest\032\026.vision.CommonResopnse\022M\n\021Sta" +
      "rtVisonService\022 .vision.StartVisonServic" +
      "eRequest\032\026.vision.CommonResopnseB=\n)com." +
      "example.ex3_2_back.grpc.server.visionB\013V" +
      "isionProtoP\001\210\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_vision_FaceCollectionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_vision_FaceCollectionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vision_FaceCollectionRequest_descriptor,
        new java.lang.String[] { "UserId", "Identity", "Username", "PullUrl", "PushUrl", });
    internal_static_vision_RemoveUrlRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_vision_RemoveUrlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vision_RemoveUrlRequest_descriptor,
        new java.lang.String[] { "UserId", "Identity", "Username", });
    internal_static_vision_CommonResopnse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_vision_CommonResopnse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vision_CommonResopnse_descriptor,
        new java.lang.String[] { "Code", "Message", });
    internal_static_vision_StartVisonServiceRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_vision_StartVisonServiceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vision_StartVisonServiceRequest_descriptor,
        new java.lang.String[] { "CameraId", "PullUrl", "PushUrl", "ModelId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
