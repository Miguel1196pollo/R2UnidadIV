package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Member;


public interface MemberRepository extends CrudRepository<Member,Integer> {

}
