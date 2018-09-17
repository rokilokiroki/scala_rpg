trait Factory {
  def create(): Character

}

object CharacterFactory extends Factory {
  override def create(): Character = {
    val character = new Character
    return character
  }
}