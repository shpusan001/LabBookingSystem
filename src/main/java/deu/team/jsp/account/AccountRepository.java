package deu.team.jsp.account;

import deu.team.jsp.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByStudentId(String StudentId);

    //좌석 예약 시 예약 상태 업데이트
    @Transactional
    @Modifying
    @Query("update Account a set a.bookStatus=1 where a.studentId=:studentId")
    void updateBookStatus(@Param("studentId")String studentId);

}
