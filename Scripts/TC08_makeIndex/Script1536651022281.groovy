import com.kazurayam.materials.MaterialRepository
import internal.GlobalVariable

// prepare instance of MaterialRepository
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// make ./Material/index.html file
mr.makeIndex()