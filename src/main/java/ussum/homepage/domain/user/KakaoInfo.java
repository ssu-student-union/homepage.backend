package ussum.homepage.domain.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KakaoInfo {
    @JsonProperty("id")
    private Long id;


//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public static KakaoInfo of(Long id){
        return new KakaoInfo(id);
    }
}
