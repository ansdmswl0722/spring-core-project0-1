import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.task.DoorayMessageSender;
import com.nhnacademy.task.MessageSendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
@ExtendWith(SpringExtension.class)
@ContextConfiguration("/beans.xml")
public class IntegrationTest {

    @Autowired
    @InjectMocks
    private  MessageSendService messageSendService;
    @Test
   void MessageSendServiceIntegrationTest() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        doNothing().when(doorayHookSender).send(any(DoorayHook.class));

        Assertions.assertThat(messageSendService.doSendMessage()).isEqualTo(true);
    }

}