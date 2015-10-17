package apaw.ecp2.rest.data.models.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apaw.ecp2.rest.data.models.daos.VoteDao;
import apaw.ecp2.rest.data.models.entities.Theme;
import apaw.ecp2.rest.data.models.entities.Vote;

public class VoteMemoryDao extends GenericMemoryDao<Vote, Integer> implements VoteDao {

    public VoteMemoryDao() {
        this.setMap(new HashMap<Integer, Vote>());
    }

    @Override
    protected Integer getId(Vote entity) {
        return entity.getId();
    }

    @Override
    public List<Vote> findByTheme(Theme theme) {
        List<Vote> votes = new ArrayList<>();
        List<Vote> votesAll = this.findAll();
        for (Vote vote : votesAll) {
            if (theme.equals(vote.getTheme())) {
                votes.add(vote);
            }
        }
        return votes;
    }

}
