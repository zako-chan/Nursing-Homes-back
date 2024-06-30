package com.example.ex3_2_back.grpc.server.message;


import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.repository.ElderlyRepository;
import com.example.ex3_2_back.repository.EventInfoRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@Slf4j
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase{

    @Autowired
    private EventInfoRepository eventInfoRepository;

    @Autowired
    private ElderlyRepository elderlyRepository;

    @Override
    public void model1Request(Model1RequestMessage request, StreamObserver<Model1ResponseMessage> responseObserver) {
        try {
            log.info("Moder1Request: " + request);
            String modelId = request.getModelId();
            String userId = request.getUserId();
            String userName = request.getUsername();

        } catch (Exception e){
            Model1ResponseMessage response = Model1ResponseMessage.newBuilder()
                    .setCode("500")
                    .build();
        }
    }

}
