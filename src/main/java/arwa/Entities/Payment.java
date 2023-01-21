package arwa.Entities;

import arwa.enumerates.PaymentStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity {
    @Column(name = "paypal_payment_id")
    private String paypalPaymentId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "status_ID", nullable = false)
    @NotNull
    private PaymentStatus status;
    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Payment(String paypalPaymentId, @NotNull PaymentStatus status, @NotNull
    BigDecimal amount) {
        this.paypalPaymentId = paypalPaymentId;
        this.status = status;
        this.amount = amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paypalPaymentId, payment.paypalPaymentId);
    }
    @Override
    public int hashCode() { return Objects.hash(paypalPaymentId); }
}
