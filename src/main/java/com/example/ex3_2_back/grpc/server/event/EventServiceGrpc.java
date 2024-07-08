package com.example.ex3_2_back.grpc.server.event;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: event.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EventServiceGrpc {

  private EventServiceGrpc() {}

  public static final String SERVICE_NAME = "event.EventService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFaceRecognitionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FaceRecognitionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFaceRecognitionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFaceRecognitionEventMethod;
    if ((getFaceRecognitionEventMethod = EventServiceGrpc.getFaceRecognitionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getFaceRecognitionEventMethod = EventServiceGrpc.getFaceRecognitionEventMethod) == null) {
          EventServiceGrpc.getFaceRecognitionEventMethod = getFaceRecognitionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FaceRecognitionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("FaceRecognitionEvent"))
              .build();
        }
      }
    }
    return getFaceRecognitionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getEmotionDetectionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmotionDetectionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getEmotionDetectionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getEmotionDetectionEventMethod;
    if ((getEmotionDetectionEventMethod = EventServiceGrpc.getEmotionDetectionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getEmotionDetectionEventMethod = EventServiceGrpc.getEmotionDetectionEventMethod) == null) {
          EventServiceGrpc.getEmotionDetectionEventMethod = getEmotionDetectionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmotionDetectionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("EmotionDetectionEvent"))
              .build();
        }
      }
    }
    return getEmotionDetectionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getVolunteerInteractionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VolunteerInteractionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getVolunteerInteractionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getVolunteerInteractionEventMethod;
    if ((getVolunteerInteractionEventMethod = EventServiceGrpc.getVolunteerInteractionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getVolunteerInteractionEventMethod = EventServiceGrpc.getVolunteerInteractionEventMethod) == null) {
          EventServiceGrpc.getVolunteerInteractionEventMethod = getVolunteerInteractionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VolunteerInteractionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("VolunteerInteractionEvent"))
              .build();
        }
      }
    }
    return getVolunteerInteractionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getStrangerDetectionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StrangerDetectionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getStrangerDetectionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getStrangerDetectionEventMethod;
    if ((getStrangerDetectionEventMethod = EventServiceGrpc.getStrangerDetectionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getStrangerDetectionEventMethod = EventServiceGrpc.getStrangerDetectionEventMethod) == null) {
          EventServiceGrpc.getStrangerDetectionEventMethod = getStrangerDetectionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StrangerDetectionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("StrangerDetectionEvent"))
              .build();
        }
      }
    }
    return getStrangerDetectionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFallDetectionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FallDetectionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFallDetectionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFallDetectionEventMethod;
    if ((getFallDetectionEventMethod = EventServiceGrpc.getFallDetectionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getFallDetectionEventMethod = EventServiceGrpc.getFallDetectionEventMethod) == null) {
          EventServiceGrpc.getFallDetectionEventMethod = getFallDetectionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FallDetectionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("FallDetectionEvent"))
              .build();
        }
      }
    }
    return getFallDetectionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getForbiddenAreaInvasionDetectionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ForbiddenAreaInvasionDetectionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getForbiddenAreaInvasionDetectionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getForbiddenAreaInvasionDetectionEventMethod;
    if ((getForbiddenAreaInvasionDetectionEventMethod = EventServiceGrpc.getForbiddenAreaInvasionDetectionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getForbiddenAreaInvasionDetectionEventMethod = EventServiceGrpc.getForbiddenAreaInvasionDetectionEventMethod) == null) {
          EventServiceGrpc.getForbiddenAreaInvasionDetectionEventMethod = getForbiddenAreaInvasionDetectionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ForbiddenAreaInvasionDetectionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("ForbiddenAreaInvasionDetectionEvent"))
              .build();
        }
      }
    }
    return getForbiddenAreaInvasionDetectionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFireDetectionEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FireDetectionEvent",
      requestType = com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFireDetectionEventMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getFireDetectionEventMethod;
    if ((getFireDetectionEventMethod = EventServiceGrpc.getFireDetectionEventMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getFireDetectionEventMethod = EventServiceGrpc.getFireDetectionEventMethod) == null) {
          EventServiceGrpc.getFireDetectionEventMethod = getFireDetectionEventMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FireDetectionEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("FireDetectionEvent"))
              .build();
        }
      }
    }
    return getFireDetectionEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getUpdateImageUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateImageUrl",
      requestType = com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.event.EventServerResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest,
      com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getUpdateImageUrlMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse> getUpdateImageUrlMethod;
    if ((getUpdateImageUrlMethod = EventServiceGrpc.getUpdateImageUrlMethod) == null) {
      synchronized (EventServiceGrpc.class) {
        if ((getUpdateImageUrlMethod = EventServiceGrpc.getUpdateImageUrlMethod) == null) {
          EventServiceGrpc.getUpdateImageUrlMethod = getUpdateImageUrlMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest, com.example.ex3_2_back.grpc.server.event.EventServerResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateImageUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.event.EventServerResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new EventServiceMethodDescriptorSupplier("UpdateImageUrl"))
              .build();
        }
      }
    }
    return getUpdateImageUrlMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventServiceStub>() {
        @java.lang.Override
        public EventServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventServiceStub(channel, callOptions);
        }
      };
    return EventServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventServiceBlockingStub>() {
        @java.lang.Override
        public EventServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventServiceBlockingStub(channel, callOptions);
        }
      };
    return EventServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventServiceFutureStub>() {
        @java.lang.Override
        public EventServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventServiceFutureStub(channel, callOptions);
        }
      };
    return EventServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *    rpc CreateEvent(EventRequest) returns (EventServerResopnse);
     * </pre>
     */
    default void faceRecognitionEvent(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFaceRecognitionEventMethod(), responseObserver);
    }

    /**
     */
    default void emotionDetectionEvent(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEmotionDetectionEventMethod(), responseObserver);
    }

    /**
     */
    default void volunteerInteractionEvent(com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVolunteerInteractionEventMethod(), responseObserver);
    }

    /**
     */
    default void strangerDetectionEvent(com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStrangerDetectionEventMethod(), responseObserver);
    }

    /**
     */
    default void fallDetectionEvent(com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFallDetectionEventMethod(), responseObserver);
    }

    /**
     */
    default void forbiddenAreaInvasionDetectionEvent(com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getForbiddenAreaInvasionDetectionEventMethod(), responseObserver);
    }

    /**
     */
    default void fireDetectionEvent(com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFireDetectionEventMethod(), responseObserver);
    }

    /**
     */
    default void updateImageUrl(com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateImageUrlMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EventService.
   */
  public static abstract class EventServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EventServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EventService.
   */
  public static final class EventServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EventServiceStub> {
    private EventServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc CreateEvent(EventRequest) returns (EventServerResopnse);
     * </pre>
     */
    public void faceRecognitionEvent(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFaceRecognitionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void emotionDetectionEvent(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEmotionDetectionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void volunteerInteractionEvent(com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVolunteerInteractionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void strangerDetectionEvent(com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStrangerDetectionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fallDetectionEvent(com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFallDetectionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forbiddenAreaInvasionDetectionEvent(com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getForbiddenAreaInvasionDetectionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fireDetectionEvent(com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFireDetectionEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateImageUrl(com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateImageUrlMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EventService.
   */
  public static final class EventServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventServiceBlockingStub> {
    private EventServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc CreateEvent(EventRequest) returns (EventServerResopnse);
     * </pre>
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse faceRecognitionEvent(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFaceRecognitionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse emotionDetectionEvent(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEmotionDetectionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse volunteerInteractionEvent(com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVolunteerInteractionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse strangerDetectionEvent(com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStrangerDetectionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse fallDetectionEvent(com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFallDetectionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse forbiddenAreaInvasionDetectionEvent(com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getForbiddenAreaInvasionDetectionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse fireDetectionEvent(com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFireDetectionEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.event.EventServerResopnse updateImageUrl(com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateImageUrlMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EventService.
   */
  public static final class EventServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventServiceFutureStub> {
    private EventServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc CreateEvent(EventRequest) returns (EventServerResopnse);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> faceRecognitionEvent(
        com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFaceRecognitionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> emotionDetectionEvent(
        com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEmotionDetectionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> volunteerInteractionEvent(
        com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVolunteerInteractionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> strangerDetectionEvent(
        com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStrangerDetectionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> fallDetectionEvent(
        com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFallDetectionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> forbiddenAreaInvasionDetectionEvent(
        com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getForbiddenAreaInvasionDetectionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> fireDetectionEvent(
        com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFireDetectionEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.event.EventServerResopnse> updateImageUrl(
        com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateImageUrlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FACE_RECOGNITION_EVENT = 0;
  private static final int METHODID_EMOTION_DETECTION_EVENT = 1;
  private static final int METHODID_VOLUNTEER_INTERACTION_EVENT = 2;
  private static final int METHODID_STRANGER_DETECTION_EVENT = 3;
  private static final int METHODID_FALL_DETECTION_EVENT = 4;
  private static final int METHODID_FORBIDDEN_AREA_INVASION_DETECTION_EVENT = 5;
  private static final int METHODID_FIRE_DETECTION_EVENT = 6;
  private static final int METHODID_UPDATE_IMAGE_URL = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FACE_RECOGNITION_EVENT:
          serviceImpl.faceRecognitionEvent((com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_EMOTION_DETECTION_EVENT:
          serviceImpl.emotionDetectionEvent((com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_VOLUNTEER_INTERACTION_EVENT:
          serviceImpl.volunteerInteractionEvent((com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_STRANGER_DETECTION_EVENT:
          serviceImpl.strangerDetectionEvent((com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_FALL_DETECTION_EVENT:
          serviceImpl.fallDetectionEvent((com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_FORBIDDEN_AREA_INVASION_DETECTION_EVENT:
          serviceImpl.forbiddenAreaInvasionDetectionEvent((com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_FIRE_DETECTION_EVENT:
          serviceImpl.fireDetectionEvent((com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        case METHODID_UPDATE_IMAGE_URL:
          serviceImpl.updateImageUrl((com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.event.EventServerResopnse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFaceRecognitionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_FACE_RECOGNITION_EVENT)))
        .addMethod(
          getEmotionDetectionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_EMOTION_DETECTION_EVENT)))
        .addMethod(
          getVolunteerInteractionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.VolunteerInteractionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_VOLUNTEER_INTERACTION_EVENT)))
        .addMethod(
          getStrangerDetectionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.StrangerDetectionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_STRANGER_DETECTION_EVENT)))
        .addMethod(
          getFallDetectionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.FallDetectionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_FALL_DETECTION_EVENT)))
        .addMethod(
          getForbiddenAreaInvasionDetectionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.ForbiddenAreaInvasionDetectionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_FORBIDDEN_AREA_INVASION_DETECTION_EVENT)))
        .addMethod(
          getFireDetectionEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.FireDetectionEventRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_FIRE_DETECTION_EVENT)))
        .addMethod(
          getUpdateImageUrlMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.event.UpdateImageUrlRequest,
              com.example.ex3_2_back.grpc.server.event.EventServerResopnse>(
                service, METHODID_UPDATE_IMAGE_URL)))
        .build();
  }

  private static abstract class EventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventService");
    }
  }

  private static final class EventServiceFileDescriptorSupplier
      extends EventServiceBaseDescriptorSupplier {
    EventServiceFileDescriptorSupplier() {}
  }

  private static final class EventServiceMethodDescriptorSupplier
      extends EventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventServiceFileDescriptorSupplier())
              .addMethod(getFaceRecognitionEventMethod())
              .addMethod(getEmotionDetectionEventMethod())
              .addMethod(getVolunteerInteractionEventMethod())
              .addMethod(getStrangerDetectionEventMethod())
              .addMethod(getFallDetectionEventMethod())
              .addMethod(getForbiddenAreaInvasionDetectionEventMethod())
              .addMethod(getFireDetectionEventMethod())
              .addMethod(getUpdateImageUrlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
