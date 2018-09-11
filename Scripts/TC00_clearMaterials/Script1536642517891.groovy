import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.materials.Helpers
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * TC00_clearMaterials
 * 
 * recursively delete the directories and files under the Materials directory
 * 
 * @author kazurayam
 */

Path materialsDir = Paths.get(RunConfiguration.getProjectDir()).resolve('Materials')

Helpers.deleteDirectoryContents(materialsDir)