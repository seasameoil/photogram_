package photogram.cos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photogram.cos.domain.subscribe.Subscribe;
import photogram.cos.domain.subscribe.SubscribeRepository;
import photogram.cos.handler.ex.CustomApiException;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void 구독하기(int fromUserId, int toUserId) {

        try {
            subscribeRepository.mSubscribe(fromUserId, toUserId);
        } catch(Exception e) {
            throw new CustomApiException("이미 구독을 하였습니다.");
        }
    }

    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId) {

        subscribeRepository.mUnSubscribe(fromUserId, toUserId);
    }
}
