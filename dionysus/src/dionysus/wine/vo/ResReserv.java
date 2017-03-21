package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class ResReserv {
       private int resResrvId;
       private Date resResrvDate;
       private int resResrvFee;
       private int customerId;
       private int resId;
}
