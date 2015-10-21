package apaw.ecp2.rest.data.models.daos;

import java.util.List;

import apaw.ecp2.rest.data.models.entities.Theme;

public interface ThemeDao extends GenericDao<Theme, Integer>{

	public Theme findByName(String themeName);

	public List<String> findAllNames();

}
