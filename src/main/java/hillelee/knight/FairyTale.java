package hillelee.knight;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

public class FairyTale {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("hillelee");

        Knight knight1 = ctx.getBean(Knight.class);
        Knight knight2 = ctx.getBean(Knight.class);



        System.out.println("Knight: " + knight1);
        System.out.println("Knights are same: " + (knight1 == knight2));
        System.out.println("Quests are same: " + (knight1.getQuest() == knight2.getQuest()));
    }
}

@Configuration
class Config {
    @Bean
        //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Knight knight(/*@Qualifier("quest")*/ Quest quest) {
        return new Knight(quest);
    }

    @Bean
    @Primary
    Quest killDragon() {
        return new Quest("Kill the Dragon");
    }

    @Bean
    Quest rescuePrincess(){
        return new Quest("Rescue the Princess");
    }

    @Bean
    String task(){
        return "do nothing";
    }
}

@Data
//@Component("myKnight")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Knight {
    private final Quest quest;
}

@Data
@AllArgsConstructor
@Component
class Quest {
    private String task = "Kill the Dragon";


}
